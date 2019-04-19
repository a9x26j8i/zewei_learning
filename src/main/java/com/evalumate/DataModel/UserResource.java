package com.evalumate.DataModel;

import com.newsoftvalley.rest.NewSoftValleyResource;

import java.util.HashMap;
import java.util.Map;

public class UserResource extends NewSoftValleyResource<Long, User> {
    Map<Long, User> idToUsermap;

    public UserResource() {
        idToUsermap = new HashMap<>();
    }

    @Override
    public Long create(User user) {
        idToUsermap.put(123l, new User());
        return 123l;
    }

    @Override
    public void update(Long id, User user) {
        idToUsermap.put(id, user);
    }
}
