package tutorpro.logic.commands;

import static java.util.Objects.requireNonNull;
import static tutorpro.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static tutorpro.logic.parser.CliSyntax.PREFIX_EMAIL;
import static tutorpro.logic.parser.CliSyntax.PREFIX_NAME;
import static tutorpro.logic.parser.CliSyntax.PREFIX_PHONE;
import static tutorpro.logic.parser.CliSyntax.PREFIX_TAG;

import tutorpro.commons.util.ToStringBuilder;
import tutorpro.logic.Messages;
import tutorpro.logic.commands.exceptions.CommandException;
import tutorpro.model.Model;
import tutorpro.model.person.student.Parent;

/**
 * Adds a person to the address book.
 */
public class AddParentCommand extends Command {

    public static final String COMMAND_WORD = "addp";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a parent to your contacts. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe Senior "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnds@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_TAG + "isWise "
            + PREFIX_TAG + "owesMoney";

    public static final String MESSAGE_SUCCESS = "New parent added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This parent already exists in the address book";

    private final Parent toAdd;

    /**
     * Creates an AddParentCommand to add the specified {@code Person}
     */
    public AddParentCommand(Parent parent) {
        requireNonNull(parent);
        toAdd = parent;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addPerson(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddCommand)) {
            return false;
        }

        AddParentCommand otherAddCommand = (AddParentCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}
