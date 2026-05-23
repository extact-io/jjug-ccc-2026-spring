package sample;

import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class PersonSample {

    private PersonService service = new PersonServiceStub();

    public PersonDto getPerson(int id) {
        return service.getPerson(id).transform(PersonDto::toDto);
    }
    public PersonDto updatePerson(PersonDto dto) {
        return service.updatePerson(dto.toEntity()).transform(PersonDto::toDto);
    }


    // ------------------------------------------------- inner classes.

    @Getter
    @AllArgsConstructor(staticName = "of")
    static class PersonDto {
        private int id;
        private String name;
        Person toEntity() {
            return Person.of(this.id, this.name);
        }
        static PersonDto toDto(Person source) {
            return PersonDto.of(source.getId(), source.getName());
        }
    }

    interface Transformable {
        @SuppressWarnings("unchecked")
        default <T, R> R transform(Function<T, R> func) {
            return func.apply((T) this);
        }
    }

    @Getter
    @AllArgsConstructor(staticName = "of")
    static class Person implements Transformable {
        private int id;
        private String name;
    }

    interface PersonService {
        Person getPerson(int id);
        Person updatePerson(Person entity);
    }


    // ------------------------------------------------- dummy code.

    static class PersonServiceStub implements PersonService {
        @Override
        public Person getPerson(int id) {
            return Person.of(id, "test-dummy");
        }
        @Override
        public Person updatePerson(Person entity) {
            return Person.of(entity.id, entity.name);
        }
    }
}
