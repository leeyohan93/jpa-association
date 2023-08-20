package persistence.sql.dml.builder;

import model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persistence.entity.model.EntityMeta;
import persistence.entity.model.EntityMetaFactory;

import static fixture.PersonFixtures.savedPerson;
import static org.assertj.core.api.Assertions.assertThat;

class UpdateQueryBuilderTest {
    private final UpdateQueryBuilder updateQueryBuilder = UpdateQueryBuilder.INSTANCE;

    @Test
    @DisplayName("update 쿼리를 반환한다")
    void updateQuery() {
        // given
        Person person = savedPerson();
        person.changeName("lee");
        EntityMeta entityMeta = EntityMetaFactory.INSTANCE.create(person.getClass());

        // when
        String updateQuery = updateQueryBuilder.update(entityMeta, person);

        // then
        assertThat(updateQuery).isEqualTo("update users set nick_name = 'lee', old = 31, email = 'yohan@google.com' where id=1");
    }
}