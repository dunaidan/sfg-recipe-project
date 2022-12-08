package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.NotesCommand;
import guru.springframework.sfgrecipeproject.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    public static final long ID = 1L;
    public static final String NOTES = "Recipe Notes";
    NotesCommandToNotes notesConverter;
    NotesCommand notesCommand;

    @BeforeEach
    void setUp() {
        notesConverter = new NotesCommandToNotes();

        notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        notesCommand.setRecipeNotes(NOTES);
    }

    @Test
    void convert() {
        //given
        Notes notes;

        //when
        notes = notesConverter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID, notes.getId());
        assertEquals(NOTES, notes.getRecipeNotes());
    }
}