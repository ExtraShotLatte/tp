package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.LinkContactCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

/**
 * Parses input arguments and creates a new LinkCommand object
 */
public class LinkContactCommandParser implements Parser<LinkContactCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an LinkContactCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public LinkContactCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_CONTACT);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, LinkContactCommand.MESSAGE_USAGE), pe);
        }

        if (argMultimap.getValue(PREFIX_CONTACT).isPresent()) {
            return new LinkContactCommand(index, argMultimap.getValue(PREFIX_CONTACT).get());
        } else {
            throw new ParseException(LinkContactCommand.CONTACT_NOT_LINKED);
        }
    }
}
