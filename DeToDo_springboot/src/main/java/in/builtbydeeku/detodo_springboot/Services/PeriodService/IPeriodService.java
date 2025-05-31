package in.builtbydeeku.detodo_springboot.Services.PeriodService;

import in.builtbydeeku.detodo_springboot.Models.Period;

import java.util.List;

public interface IPeriodService {
    public Period addPeriod(Period period);
    public Period updatePeriodById(Period period,int periodId);
    public void deletePeriodById(int periodId);
    public List<Period> getAllPeriods();
}
