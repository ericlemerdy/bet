package fr.valtech.bet.service.match;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.match.Match;
import fr.valtech.bet.domain.model.match.dto.MatchDto;
import fr.valtech.bet.domain.model.match.dto.OddsDto;
import fr.valtech.bet.domain.model.user.User;

public interface MatchService {

    @Transactional(readOnly = true)
    List<MatchDto> findMatchByDateByUser(Date date, User currentUser);

    List<Date> findDates();

    List<OddsDto> saveUserBets(List<MatchDto> dtos, User user);

    List<MatchDto> transform(List<Map<String, String>> dtos);

    List<fr.valtech.bet.domain.model.match.dto.AdminMatchDto> findMatches();

    void updateScoreMatch(List<Map<String,String>> dtos);

    List<Match> findByLevel(String level);
}
