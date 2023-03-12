
package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.contact.Contact;
import seedu.address.model.contact.ContactName;
import seedu.address.model.contact.ContactPhone;
import seedu.address.model.person.Address;
import seedu.address.model.person.Event;
import seedu.address.model.person.Name;
import seedu.address.model.person.Rate;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_RATE = "85355255";
    public static final String DEFAULT_CONTACTNAME = "Amy";
    public static final String DEFAULT_CONTACTNUM = "91234567";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Rate rate;
    private Address address;
    private Contact contact;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        rate = new Rate(DEFAULT_RATE);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        contact = new Contact(new ContactName(DEFAULT_CONTACTNAME), new ContactPhone(DEFAULT_CONTACTNUM));
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Event personToCopy) {
        name = personToCopy.getName();
        rate = personToCopy.getRate();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        contact = new Contact(new ContactName(DEFAULT_CONTACTNAME), new ContactPhone(DEFAULT_CONTACTNUM));
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withRate(String rate) {
        this.rate = new Rate(rate);
        return this;
    }

    /**
     * Sets the {@code Contact} of the {@code Person} that we are building.
     */
    public PersonBuilder withContact(String name, String number) {
        this.contact = new Contact(new ContactName(name), new ContactPhone(number));
        return this;
    }

    public Event build() {
        if (this.contact.equals(new Contact(new ContactName(DEFAULT_CONTACTNAME), new ContactPhone(DEFAULT_CONTACTNUM)))) {
            return new Event(name, rate, address, tags);
        } else {
            return new Event(name, rate, address, tags, contact);
        }
    }
}
