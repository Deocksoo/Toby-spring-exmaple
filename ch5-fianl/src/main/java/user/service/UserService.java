package user.service;

import user.domain.User;

public interface UserService {
    void add(User user);

    void upgradeLevels();
}
