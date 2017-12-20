package com.gmail.drafts;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import com.properties.PropertiesReading;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DraftsTest extends BaseTest {
    private PagesFactory pages= new PagesFactory(driver);

    public DraftsTest(Browsers.name browserName) {
        super(browserName);
    }

    @Before
    public void setUpAuth(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        pages.getPasswordPage().submitPassword();
    }

    @Test
    public void addMessageToDrafts(){
        pages.getInboxPage().clickComposeButton();
        pages.getInboxPage().inputMessageSubject("example");
        Assert.assertTrue("Saved Label is not presented",
                pages.getInboxPage().isSavedLabelPresented());
        pages.getInboxPage().clickDraftsLink();
        Assert.assertTrue("Draft Page is not opened",
                pages.getDraftsPage().isDraftPageOpened());
        Assert.assertTrue("No message with this subject in drafts",
                pages.getDraftsPage().isDraftAdded("example"));
    }

    @Test
    public void deleteMessageFromDrafts(){
        pages.getInboxPage().clickDraftsLink();
        Assert.assertTrue("Draft Page is not opened",
                pages.getDraftsPage().isDraftPageOpened());
        pages.getDraftsPage().chooseFirstDraft();
        int countOfDraftsAtStart = pages.getDraftsPage().getCountOfDrafts();
        pages.getDraftsPage().clickDiscardDraftButton();
        Assert.assertEquals("Count of drafts at start and after discarding doesn't match",
                countOfDraftsAtStart-1, pages.getDraftsPage().getCountOfDrafts());
    }
}
