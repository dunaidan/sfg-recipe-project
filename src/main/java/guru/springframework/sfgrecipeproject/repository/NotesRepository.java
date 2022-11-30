package guru.springframework.sfgrecipeproject.repository;

import guru.springframework.sfgrecipeproject.domain.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {
}
