package guru.springframework.sfgrecipeproject.repository;

import guru.springframework.sfgrecipeproject.domain.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {
}
