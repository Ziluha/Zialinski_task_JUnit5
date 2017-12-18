package com.gmail.drafts;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DraftsTest extends BaseTest {
    private PagesFactory pages= new PagesFactory();

    public DraftsTest(Browsers.name browserName) {
        super(browserName);
    }

    @Before
    public void setUpAuth(){
        pages.getLoginPage(driver).inputLogin("test.task.zel");
        pages.getLoginPage(driver).submitLogin();
        pages.getPasswordPage(driver).inputPassword("Test1234Test");
        pages.getPasswordPage(driver).submitPassword();
    }

    @Test
    public void addMessageToDrafts(){
        pages.getInboxPage(driver).clickComposeButton();
        pages.getInboxPage(driver).inputMessageSubject("example");
        Assert.assertTrue("Saved Label is not presented",
                pages.getInboxPage(driver).isSavedLabelPresented());
        pages.getInboxPage(driver).clickDraftsLink();
        Assert.assertTrue("Draft Page is not opened",
                pages.getDraftsPage(driver).isDraftPageOpened());
        Assert.assertTrue("No message with this subject in drafts",
                pages.getDraftsPage(driver).isDraftAdded("example"));
    }

    @Test
    public void deleteMessageFromDrafts(){
        pages.getInboxPage(driver).clickDraftsLink();
        Assert.assertTrue("Draft Page is not opened",
                pages.getDraftsPage(driver).isDraftPageOpened());
        int countOfDraftsAtStart = pages.getDraftsPage(driver).getCountOfDrafts();
        pages.getDraftsPage(driver).chooseFirstDraft();
        pages.getDraftsPage(driver).clickDiscardDraftButton();
        Assert.assertEquals("Count of drafts at start and after discarding doesn't match",
                countOfDraftsAtStart-1, pages.getDraftsPage(driver).getCountOfDrafts());
    }
}
