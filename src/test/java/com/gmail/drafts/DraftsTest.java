package com.gmail.drafts;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.*;
import sun.jvm.hotspot.debugger.Page;
import static org.junit.jupiter.api.Assertions.*;

public class DraftsTest extends BaseTest {
    private PagesFactory pages= new PagesFactory();

    public DraftsTest() {
        super(Browsers.name.Chrome);
    }

    @BeforeEach
    public void setUpAuth(){
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("Test1234Test");
        pages.getPasswordPage().submitPassword();
    }

    @Test
    public void addMessageToDrafts(){
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

    @Test
    public void deleteMessageFromDrafts(){
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
