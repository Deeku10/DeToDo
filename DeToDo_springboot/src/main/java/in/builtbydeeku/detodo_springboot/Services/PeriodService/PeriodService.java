package in.builtbydeeku.detodo_springboot.Services.PeriodService;

import in.builtbydeeku.detodo_springboot.Exceptions.ObjectNotFoundException;
import in.builtbydeeku.detodo_springboot.Models.Period;
import in.builtbydeeku.detodo_springboot.Repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodService implements IPeriodService{
    @Autowired
    private PeriodRepository periodRepository;

    @Override
    public Period addPeriod(Period period) {
        return Optional.ofNullable(period)
                .map(periodRepository::save)
                .orElseThrow(()-> new ObjectNotFoundException("Object Not found"));
    }

    @Override
    public Period updatePeriodById(Period period, int periodId) {
        return Optional.of(periodRepository.findById(periodId).orElseThrow(()-> new ObjectNotFoundException("Object Not found")))
                .map(oldPeriod->{
                    oldPeriod.setTitle(period.getTitle());
                    return periodRepository.save(oldPeriod);
                })
                .orElseThrow(()-> new ObjectNotFoundException("Object Not found"));
    }

    @Override
    public void deletePeriodById(int periodId) {
       periodRepository.deleteById(periodId);
    }

    @Override
    public List<Period> getAllPeriods() {
        return periodRepository.findAll();
    }

}
