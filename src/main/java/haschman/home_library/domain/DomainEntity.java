package haschman.home_library.domain;

import java.io.Serializable;

public interface DomainEntity<ID> extends Serializable {
    ID getId();
}
