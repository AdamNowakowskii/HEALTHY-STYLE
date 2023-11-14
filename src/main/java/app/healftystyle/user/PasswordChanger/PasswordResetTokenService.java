package app.healftystyle.user.PasswordChanger;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PasswordResetTokenService {
    PasswordResetTokenRepository tokenRepository;

    public void save (PasswordResetTokenDTO resetToken){
        tokenRepository.save(MapperToEntity.map(resetToken));
    }

    public void delete(String token){
        MapperToEntity.map(tokenRepository.deleteByToken(token));
    }

    public  PasswordResetTokenDTO findByToken(String token) {
        return MapperToDTO.map(tokenRepository.findByToken(token));
    }
}
class MapperToEntity{
    public static PasswordResetToken map (PasswordResetTokenDTO reset) {
        return new PasswordResetToken(null,
                                      reset.getToken(),
                                      reset.getUser(),
                                      reset.getExpiryDate());
    }
}
class  MapperToDTO{
    public static PasswordResetTokenDTO map (PasswordResetToken resetToken){
        return new PasswordResetTokenDTO(resetToken.getToken(),resetToken.getUser(),resetToken.getExpiryDate());
    }
}
