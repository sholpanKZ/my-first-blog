package kz.sholpan.myfirstblog.domain.news.repository;

import kz.sholpan.myfirstblog.domain.news.model.News;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Long> {


}
