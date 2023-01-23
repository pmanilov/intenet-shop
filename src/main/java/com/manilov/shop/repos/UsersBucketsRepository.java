package com.manilov.shop.repos;

import com.manilov.shop.domain.UsersBuckets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersBucketsRepository extends JpaRepository<UsersBuckets, Long> {
    List<UsersBuckets> findAllByUserId(Long user_id);
}
