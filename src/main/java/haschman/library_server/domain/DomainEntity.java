package haschman.library_server.domain;

import java.io.Serializable;

public interface DomainEntity<ID> extends Serializable {
    ID getId();
}
