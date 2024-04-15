package tutorpro.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import tutorpro.commons.exceptions.IllegalValueException;
import tutorpro.model.person.Address;
import tutorpro.model.person.Email;
import tutorpro.model.person.Name;
import tutorpro.model.person.Person;
import tutorpro.model.person.Phone;
import tutorpro.model.schedule.Event;
import tutorpro.model.tag.Tag;

public class JsonAdaptedEventTest {

    private static final String VALID_NAME = "Meeting";
    private static final LocalDateTime VALID_TIME = LocalDateTime.of(2022, 1, 1, 10, 0);
    private static final String VALID_NOTES = "Discuss project";
    private static final List<String> VALID_PEOPLE = Arrays.asList("Alice", "Bob");
    private static final List<JsonAdaptedTag> VALID_TAGS = Arrays.asList(new JsonAdaptedTag("important"),
            new JsonAdaptedTag("urgent"));
    private static final double VALID_DURATION = 1.5;

    @Test
    public void constructor_validParameters_success() throws IllegalValueException {
        JsonAdaptedEvent jsonAdaptedEvent = new JsonAdaptedEvent(VALID_NAME, VALID_TIME, VALID_NOTES, VALID_PEOPLE,
                VALID_TAGS, VALID_DURATION);
        Event event = jsonAdaptedEvent.toModelType();

        assertEquals(VALID_NAME, event.getName());
        assertEquals(VALID_TIME, event.getTime());
        assertEquals(VALID_NOTES, event.getNotes());
        assertEquals(VALID_PEOPLE.size(), event.getPeople().size());
        assertEquals(VALID_TAGS.size(), event.getTags().size());
        assertEquals(VALID_DURATION, event.getDuration());
    }

    @Test
    public void toModelType_validParameters_success() throws IllegalValueException {
        JsonAdaptedEvent jsonAdaptedEvent = new JsonAdaptedEvent(VALID_NAME, VALID_TIME, VALID_NOTES, VALID_PEOPLE,
                VALID_TAGS, VALID_DURATION);
        Event event = jsonAdaptedEvent.toModelType();

        final List<Person> reminderPeople = new ArrayList<>();
        for (String person : VALID_PEOPLE) {
            reminderPeople.add(new Person(new Name(person), new Phone("88888888"),
                    new Email("a@bc"), new Address("0"), new HashSet<>()));
        }

        final List<Tag> reminderTags = new ArrayList<>();
        for (JsonAdaptedTag tag : VALID_TAGS) {
            reminderTags.add(tag.toModelType());
        }

        assertEquals(VALID_NAME, event.getName());
        assertEquals(VALID_TIME, event.getTime());
        assertEquals(VALID_NOTES, event.getNotes());
        assertEquals(reminderPeople.size(), event.getPeople().size());
        assertEquals(reminderTags.size(), event.getTags().size());
        assertEquals(VALID_DURATION, event.getDuration());
    }
}
