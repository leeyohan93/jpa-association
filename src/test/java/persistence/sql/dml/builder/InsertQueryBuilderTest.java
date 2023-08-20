package persistence.sql.dml.builder;

import fixture.PersonV3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persistence.entity.model.EntityMeta;
import persistence.entity.model.EntityMetaFactory;

import static org.assertj.core.api.Assertions.assertThat;

class InsertQueryBuilderTest {
    private final InsertQueryBuilder insertQueryBuilder = InsertQueryBuilder.INSTANCE;

    @Test
    @DisplayName("객체를 전달하면 insert 문을 반환한다")
    public void insert() {
        PersonV3 person = new PersonV3(
                null,
                "yohan",
                31,
                "yohan@google.com",
                1
        );
        EntityMeta entityMeta = EntityMetaFactory.INSTANCE.create(person.getClass());

        assertThat(insertQueryBuilder.insert(entityMeta, person)).isEqualTo(
                "insert into users (nick_name, old, email) values ('yohan', 31, 'yohan@google.com')"
        );
    }
}