package fun.happyhacker.springbootdemo.jpa.embeddable.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class RoleAccount {
    @EmbeddedId
    private RoleAccountId roleAccountId;
}
