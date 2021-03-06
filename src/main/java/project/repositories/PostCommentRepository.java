package project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.models.PostComment;

@Repository
public interface PostCommentRepository extends CrudRepository<PostComment, Integer>
{
    /**
     * поиск "родительского комментария"
     */
    @Query(value = "SELECT * FROM post_comments " +
            "WHERE parent_id = :parent_id " +
            "AND post_id = :post_id", nativeQuery = true)
    PostComment findByIdAndPostId(@Param("parent_id") Integer parentId, @Param("post_id") Integer postId);
}
