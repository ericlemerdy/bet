package fr.valtech.bet.service.match;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.repository.match.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MatchDto> findMatchByDateByUser(Date date, User currentUser) {
        List<MatchDto> matches = matchRepository.findMatchByDateByUser(date, currentUser);
        for (MatchDto match : matches) {
            String bet = match.getBet();
            if (StringUtils.isNotBlank(bet)) {
                String[] splitedBet = bet.split("-", 2);
                match.setBet1(Integer.valueOf(splitedBet[0]));
                match.setBet2(Integer.valueOf(splitedBet[1]));
            }
        }

        return matches;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Date> findDates() {
        return matchRepository.findDates();
    }

    @Override
    @Transactional
    public void saveUserBets(List<MatchDto> dtos, User user) {
        for (MatchDto dto : dtos) {
            if (dto.getBet1() != null && dto.getBet2() != null) {
                matchRepository.saveUserBet(dto, user);
            }
        }

    }

    @Override
    public List<MatchDto> transform(List<Map<String, String>> dtos) {
        List<MatchDto> matches = Lists.newArrayList();
        for (Map<String, String> dto : dtos) {
            MatchDto match = new MatchDto();
            match.setBetId(longValue(dto.get("betId")));
            match.setMatchId(longValue(dto.get("matchId")));
            match.setBet1(intValue(dto.get("bet1")));
            match.setBet2(intValue(dto.get("bet2")));
            matches.add(match);
        }

        return matches;
    }

    private Long longValue(String val) {
        return StringUtils.isBlank(val) ? null : Long.valueOf(val);
    }

    private Integer intValue(String val) {
        return StringUtils.isBlank(val) ? null : Integer.valueOf(val);
    }
}
