package com.gmail.drafts;

import com.enums.Browsers;
import com.gmail.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class DraftsTest extends BaseTest {
    private void setUpAuth(){
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("Test1234Test");
        pages.getPasswordPage().submitPassword();
    }

    @ParameterizedTest
    @EnumSource(Browsers.name.class)
    @DisplayName("Add message to drafts")
    public void addMessageToDrafts(Browsers.name browserName){
        initDriver(browserName);
        setUpAuth();
        pages.getInboxPage().clickComposeButton();
        pages.getInboxPage().inputMessageSubject("example");
        assertTrue(pages.getInboxPage().isSavedLabelPresented(),
                "Saved Label is not presented");
        pages.getInboxPage().clickDraftsLink();
        assertTrue(pages.getDraftsPage().isDraftPageOpened(),
                "Draft Page is not opened");
        assertTrue(pages.getDraftsPage().isDraftAdded("example"),
                "No message with this subject in drafts");
    }

    @ParameterizedTest
    @EnumSource(Browsers.name.class)
    @DisplayName("Delete message from drafts")
    public void deleteMessageFromDrafts(Browsers.name browserName){
        initDriver(browserName);
        setUpAuth();
        pages.getInboxPage().clickDraftsLink();
        assertTrue(pages.getDraftsPage().isDraftPageOpened(),
                "Draft Page is not opened");
        int countOfDraftsAtStart = pages.getDraftsPage().getCountOfDrafts();
        pages.getDraftsPage().chooseFirstDraft();
        pages.getDraftsPage().clickDiscardDraftButton();
        assertEquals(countOfDraftsAtStart-1, pages.getDraftsPage().getCountOfDrafts(),
                "Count of drafts at start and after discarding doesn't match");
    }
}
