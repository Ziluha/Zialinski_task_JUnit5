package com.gmail.drafts;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class DraftsTest extends BaseTest {
    private PagesFactory pages= new PagesFactory();

    public DraftsTest() {
        super(Browsers.name.Chrome);
    }

    @BeforeEach
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
        assertTrue(pages.getInboxPage(driver).isSavedLabelPresented(),
                "Saved Label is not presented");
        pages.getInboxPage(driver).clickDraftsLink();
        assertTrue(pages.getDraftsPage(driver).isDraftPageOpened(),
                "Draft Page is not opened");
        assertTrue(pages.getDraftsPage(driver).isDraftAdded("example"),
                "No message with this subject in drafts");
    }

    @Test
    public void deleteMessageFromDrafts(){
        pages.getInboxPage(driver).clickDraftsLink();
        assertTrue(pages.getDraftsPage(driver).isDraftPageOpened(),
                "Draft Page is not opened");
        int countOfDraftsAtStart = pages.getDraftsPage(driver).getCountOfDrafts();
        pages.getDraftsPage(driver).chooseFirstDraft();
        pages.getDraftsPage(driver).clickDiscardDraftButton();
        assertEquals(countOfDraftsAtStart-1, pages.getDraftsPage(driver).getCountOfDrafts(),
                "Count of drafts at start and after discarding doesn't match");
    }
}
