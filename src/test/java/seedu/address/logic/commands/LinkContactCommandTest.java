package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyContactList;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.contact.Contact;
import seedu.address.model.person.Event;
import seedu.address.model.person.Rate;
import seedu.address.testutil.ContactBuilder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import static seedu.address.testutil.Assert.assertThrows;

public class LinkContactCommandTest {

    @Test
    public void constructor_nullContact_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new LinkContactCommand(null, null));
    }

//    @Test
//    public void execute_linkAcceptedByModel_addSuccessful() throws Exception {
//        ModelStubAcceptingContactLinked modelStub = new LinkContactCommandTest.ModelStubAcceptingContactLinked();
//
//        //requires new EventBuilder, write next time.
//        Event validEvent = new EventBuilder()
//        Contact validContact = new ContactBuilder().build();
//
//        CommandResult commandResult = new NewContactCommand(validContact).execute(modelStub);
//
//        assertEquals(String.format(NewContactCommand.MESSAGE_SUCCESS, validContact), commandResult.getFeedbackToUser());
//        assertEquals(Arrays.asList(validContact), modelStub.contactsAdded);
//    }

    /**
     * A default model stub that has all the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getContactListFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setContactListFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Event person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyContactList getContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Event person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Event target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Event target, Event editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Event> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Event> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredContactList(Predicate<Contact> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Rate getRate(Event event) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void linkContact(Event event, Contact contact) {
            throw new AssertionError("This method should not be called.");
        }
    }

    private class ModelStubAcceptingContactLinked extends ModelStub {
        final ArrayList<Contact> contactsLinked = new ArrayList<>();

        @Override
        public void linkContact(Event event, Contact contact) {
            requireNonNull(event);
            requireNonNull(contact);


        }
    }

}
