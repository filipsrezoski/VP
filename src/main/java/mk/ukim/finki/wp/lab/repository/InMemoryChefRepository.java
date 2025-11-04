package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.Dataholder;
import mk.ukim.finki.wp.lab.model.Chef;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryChefRepository implements ChefRepository{
    @Override
    public List<Chef> findAll() {
        return Dataholder.chefs;
    }

    @Override
    public Optional<Chef> findById(Long id) {
        return Dataholder.chefs.stream().filter(chef -> chef.getId().equals(id)).findFirst();
    }

    @Override
    public Chef save(Chef chef) {
        if (Dataholder.chefs.contains(chef)) {
            int ind = Dataholder.chefs.indexOf(chef);
            Dataholder.chefs.set(ind, chef);
        } else {
            Dataholder.chefs.add(chef);
        }
        return chef;
    }
}
