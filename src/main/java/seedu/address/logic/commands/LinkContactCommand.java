package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.contact.Contact;
import seedu.address.model.contact.UniqueContactList;
import seedu.address.model.person.Event;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
 * Links an event to a contact in the event book.
 */
public class LinkContactCommand extends Command{

    public static final String COMMAND_WORD = "linkcontact";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Links event identified by the index number to the" +
            " contact specified. "
            + "Parameters: "
            + "INDEX PHONE (index must be positive integer and contact must be in contact list.)\n"
            + "Example: " + COMMAND_WORD + " 4" + " 81238123";

    public static final String MESSAGE_LINK_CONTACT_SUCCESS = "Successfully linked! %1$s";

    public static final String CONTACT_NOT_LINKED = "Only one contact to link must be provided.";

    private final Index eventIndex;
    private final String addContact;

    /**
     * @param index of the person in the filtered person list to link contact to
     * @param contactToAdd contact number of the contact to add
     */
    public LinkContactCommand(Index index, String contactToAdd){
        requireNonNull(index);
        requireNonNull(contactToAdd);
        this.eventIndex = index;
        this.addContact = contactToAdd;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Event> lastShownList = model.getFilteredPersonList();
        List<Contact> contactList = model.getContactList().getContactList();

        if (eventIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EVENT_DISPLAYED_INDEX);
        }

        Event eventToAdd = lastShownList.get(eventIndex.getZeroBased());

        try{
            Contact contactToAdd = contactList.get(UniqueContactList.contactMap.get(addContact));
            model.linkContact(eventToAdd, contactToAdd);
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        } catch (NullPointerException iobe) {
            throw new CommandException(Messages.MESSAGE_CONTACT_NOT_FOUND);
        }
        return new CommandResult(String.format(MESSAGE_LINK_CONTACT_SUCCESS, eventToAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof LinkContactCommand
                && eventIndex.equals(((LinkContactCommand) other).eventIndex)
                && addContact.equals(((LinkContactCommand) other).addContact));
    }
}
