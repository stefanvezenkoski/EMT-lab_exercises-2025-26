package mk.ukim.finki.emt_lab1.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MaterializedViewRefreshService {
    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(fixedRateString = "${app.refresh.interval:3600000}")
    public void refreshMaterializedView() {
        entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW accommodation_stats").executeUpdate();
    }
}
