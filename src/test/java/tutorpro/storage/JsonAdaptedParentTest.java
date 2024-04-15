package tutorpro.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import tutorpro.commons.exceptions.IllegalValueException;
import tutorpro.model.person.Address;
import tutorpro.model.person.Email;
import tutorpro.model.person.Name;
import tutorpro.model.person.Phone;
import tutorpro.testutil.Assert;
import tutorpro.testutil.TypicalParents;


public class JsonAdaptedParentTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_LEVEL = "P6!";
    private static final String INVALID_SUBJECT = " ";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = TypicalParents.PARIN.getName().toString();
    private static final String VALID_PHONE = TypicalParents.PARIN.getPhone().toString();
    private static final String VALID_EMAIL = TypicalParents.PARIN.getEmail().toString();
    private static final String VALID_ADDRESS = TypicalParents.PARIN.getAddress().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = TypicalParents.PARIN.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());
    private static final List<String> VALID_CHILDREN = TypicalParents.PARIN.getChildren().stream()
            .map(child -> child.getName().toString())
            .collect(Collectors.toList());

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedParent person =
                new JsonAdaptedParent(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_CHILDREN, VALID_TAGS);
        String expectedMessage =
                String.format(JsonAdaptedParent.MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedParent person =
                new JsonAdaptedParent(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                        VALID_CHILDREN, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedParent person =
                new JsonAdaptedParent(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS,
                        VALID_CHILDREN, VALID_TAGS);
        String expectedMessage =
                String.format(JsonAdaptedParent.MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedParent person =
                new JsonAdaptedParent(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                        VALID_CHILDREN, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedParent person =
                new JsonAdaptedParent(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS,
                        VALID_CHILDREN, VALID_TAGS);
        String expectedMessage =
                String.format(JsonAdaptedParent.MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedParent person =
                new JsonAdaptedParent(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                        VALID_CHILDREN, VALID_TAGS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedParent person =
                new JsonAdaptedParent(VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
                        VALID_CHILDREN, VALID_TAGS);
        String expectedMessage =
                String.format(JsonAdaptedParent.MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedParent person =
                new JsonAdaptedParent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                        VALID_CHILDREN, invalidTags);
        Assert.assertThrows(IllegalValueException.class, person::toModelType);
    }
}
