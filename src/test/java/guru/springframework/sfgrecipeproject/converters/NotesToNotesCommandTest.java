package guru.springframework.sfgrecipeproject.converters;

import guru.springframework.sfgrecipeproject.commands.NotesCommand;
import guru.springframework.sfgrecipeproject.domain.Notes;
import guru.springframework.sfgrecipeproject.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {

    public static final long ID = 1L;
    public static final String NOTES = "Recipe Notes";
    NotesToNotesCommand notesConverter;
    Notes notes;

    @BeforeEach
    void setUp() {
        notesConverter = new NotesToNotesCommand();

        notes = new Notes();
        notes.setId(ID);
        notes.setRecipeNotes(NOTES);
        notes.setRecipe(new Recipe());
    }

    @Test
    void convert() {
        //given
        NotesCommand notesCommand;

        //when
        notesCommand = notesConverter.convert(notes);

        //then
        assertNotNull(notesCommand);
        assertEquals(ID, notesCommand.getId());
        assertEquals(NOTES, notes.getRecipeNotes());
    }
}