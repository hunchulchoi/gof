package ch07_02_pacade.hometheater;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamingPlayerTest {

  @Test
  void 수동홈시어터_테스트(){

    //1. 팝콘 기계를 켠다
    PopcornPoper popcornPoper = new PopcornPoper("팝콘기계");
    popcornPoper.on();

    // 2. 팝콘 튀김
    popcornPoper.pop();

    //3. 조명을 어둡게 조절
    TheaterLights theaterLights = new TheaterLights("조명");
    theaterLights.on();
    theaterLights.setDim(10);

    //4. 스크린을 내린다.
    Screen screen = new Screen();
    screen.down();

    //5. 프로젝터를 켠다.
    Projector projector = new Projector("프로젝터");
    projector.on();

    //6. 프로젝터 플레이어를 스트리밍 플레이어로 설정
    StreamingPlayer streamingPlayer = new StreamingPlayer("스트리밍 플레이어");

    projector.setPlayer(streamingPlayer);

    //7. 와이드 스크린 모드로 설정
    projector.wideScreenMode();

    //8. 앰프를 켠다
    Amplifer amplifer = new Amplifer("앰프");
    amplifer.on();

    //9. 앰프 입력을 스트리밍 플레이어로 전환
    amplifer.setPlayer(streamingPlayer);

    //10. 앰프를 서라운드 음향 모드로 전환
   amplifer.setSurroundSound();

    //11. 앰프 볼륨을 중간(5) 로 설정
    amplifer.setVolume((short) 5);

    //12. 스트리밍 플레이어를 켠다.
    streamingPlayer.on();

    //13. 영화를 재생
    streamingPlayer.play();

    assertWatchMovie(popcornPoper, theaterLights, screen, projector, streamingPlayer, amplifer);
  }

  @Test
  void facadeTest(){

    HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
    homeTheaterFacade.watchMovie();
    assertWatchMovie(homeTheaterFacade.getPopcornPoper(), homeTheaterFacade.getTheaterLights(), homeTheaterFacade.getScreen(), homeTheaterFacade.getProjector(), homeTheaterFacade.getPlayer(), homeTheaterFacade.getAmplifer());

  }

  private void assertWatchMovie(PopcornPoper popcornPoper, TheaterLights theaterLights, Screen screen, Projector projector, Player player, Amplifer amplifer) {

    assertTrue(popcornPoper.isOn());
    assertTrue(popcornPoper.isPop());

    assertTrue(theaterLights.isOn());
    assertEquals(10, theaterLights.getDim());

    assertEquals(Screen.SCREEN_STATUS.DOWN, screen.getScreenStatus());

    assertTrue(projector.isOn());
    assertEquals(player, projector.getPlayer());
    assertEquals(Projector.MODE.WIDE_SCREEN_MODE, projector.getMode());

    assertTrue(amplifer.isOn());
    assertEquals(player, amplifer.getPlayer());
    assertEquals(Amplifer.SOUND_MODE.SURROUND_MODE, amplifer.getSoundMode());
    assertEquals(5, amplifer.getVolume());

    assertTrue(player.isOn());
    assertEquals(Player.PLAY.PLAY, player.getPlay());
  }

  @Test
  void endMovieTest(){
    HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
    homeTheaterFacade.watchMovie();
    homeTheaterFacade.endMovie();

    assertFalse(homeTheaterFacade.getPopcornPoper().isOn());
    assertFalse(homeTheaterFacade.getTheaterLights().isOn());
    assertEquals(Screen.SCREEN_STATUS.UP, homeTheaterFacade.getScreen().getScreenStatus());
    assertFalse(homeTheaterFacade.getProjector().isOn());
    assertFalse(homeTheaterFacade.getAmplifer().isOn());
    assertFalse(homeTheaterFacade.getPlayer().isOn());
  }

}