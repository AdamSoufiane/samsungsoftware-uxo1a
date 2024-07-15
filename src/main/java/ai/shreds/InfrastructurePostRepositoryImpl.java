package ai.shreds.infrastructure; 
  
 import ai.shreds.domain.DomainPostEntity; 
 import ai.shreds.domain.DomainPostRepositoryPort; 
 import ai.shreds.shared.SharedRequestParams; 
 import org.springframework.data.domain.PageRequest; 
 import org.springframework.data.domain.Pageable; 
 import org.springframework.data.domain.Sort; 
 import org.springframework.stereotype.Repository; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.jdbc.core.JdbcTemplate; 
 import org.springframework.jdbc.core.RowMapper; 
 import javax.persistence.EntityManager; 
 import javax.persistence.PersistenceContext; 
 import javax.persistence.TypedQuery; 
 import java.sql.ResultSet; 
 import java.sql.SQLException; 
 import java.util.List; 
  
 @Repository 
 public class InfrastructurePostRepositoryImpl implements DomainPostRepositoryPort { 
  
     @PersistenceContext 
     private EntityManager entityManager; 
  
     private final JdbcTemplate jdbcTemplate; 
  
     @Autowired 
     public InfrastructurePostRepositoryImpl(JdbcTemplate jdbcTemplate) { 
         this.jdbcTemplate = jdbcTemplate; 
     } 
  
     @Override 
     public List<DomainPostEntity> findAll(SharedRequestParams params) { 
         String query = buildQuery(params); 
         TypedQuery<DomainPostEntity> typedQuery = entityManager.createQuery(query, DomainPostEntity.class); 
         applyPaginationAndSorting(typedQuery, params); 
         return typedQuery.getResultList(); 
     } 
  
     @Override 
     public DomainPostEntity findById(Long id) { 
         return entityManager.find(DomainPostEntity.class, id); 
     } 
  
     @Override 
     public DomainPostEntity findBySlug(String slug) { 
         String query = "SELECT p FROM DomainPostEntity p WHERE p.post_name = :slug"; 
         TypedQuery<DomainPostEntity> typedQuery = entityManager.createQuery(query, DomainPostEntity.class); 
         typedQuery.setParameter("slug", slug); 
         return typedQuery.getSingleResult(); 
     } 
  
     private String buildQuery(SharedRequestParams params) { 
         StringBuilder queryBuilder = new StringBuilder("SELECT p FROM DomainPostEntity p WHERE 1=1"); 
         addConditions(queryBuilder, params); 
         return queryBuilder.toString(); 
     } 
  
     private void addConditions(StringBuilder queryBuilder, SharedRequestParams params) { 
         // Add conditions based on the request parameters 
         if (params.getAuthor() != null && !params.getAuthor().isEmpty()) { 
             queryBuilder.append(" AND p.post_author IN :author"); 
         } 
         // Add more conditions based on other parameters 
     } 
  
     private void applyPaginationAndSorting(TypedQuery<DomainPostEntity> typedQuery, SharedRequestParams params) { 
         Pageable pageable = PageRequest.of(params.getPage() - 1, params.getPerPage(), Sort.by(params.getOrderby())); 
         typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()); 
         typedQuery.setMaxResults(pageable.getPageSize()); 
     } 
  
     private static class PostRowMapper implements RowMapper<DomainPostEntity> { 
         @Override 
         public DomainPostEntity mapRow(ResultSet rs, int rowNum) throws SQLException { 
             DomainPostEntity post = new DomainPostEntity(); 
             post.setID(rs.getLong("ID")); 
             post.setPost_author(rs.getLong("post_author")); 
             post.setPost_date(rs.getTimestamp("post_date")); 
             post.setPost_date_gmt(rs.getTimestamp("post_date_gmt")); 
             post.setPost_content(rs.getString("post_content")); 
             post.setPost_title(rs.getString("post_title")); 
             post.setPost_excerpt(rs.getString("post_excerpt")); 
             post.setPost_status(rs.getString("post_status")); 
             post.setComment_status(rs.getString("comment_status")); 
             post.setPing_status(rs.getString("ping_status")); 
             post.setPost_password(rs.getString("post_password")); 
             post.setPost_name(rs.getString("post_name")); 
             post.setTo_ping(rs.getString("to_ping")); 
             post.setPinged(rs.getString("pinged")); 
             post.setPost_modified(rs.getTimestamp("post_modified")); 
             post.setPost_modified_gmt(rs.getTimestamp("post_modified_gmt")); 
             post.setPost_content_filtered(rs.getString("post_content_filtered")); 
             post.setPost_parent(rs.getLong("post_parent")); 
             post.setGuid(rs.getString("guid")); 
             post.setMenu_order(rs.getInt("menu_order")); 
             post.setPost_type(rs.getString("post_type")); 
             post.setPost_mime_type(rs.getString("post_mime_type")); 
             post.setComment_count(rs.getLong("comment_count")); 
             return post; 
         } 
     } 
 } 
 