package ch07_02_pacade.hometheater;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HomeTheaterFacade {

  private Amplifer amplifer;
  private Tuner tuner;
  private Player player;
  private Projector projector;
  private TheaterLights theaterLights;
  private Screen screen;
  private PopcornPoper popcornPoper;

  public HomeTheaterFacade() {
    this.amplifer = new Amplifer();
    this.tuner = new Tuner();
    this.player = new StreamingPlayer();
    this.projector = new Projector();
    this.theaterLights = new TheaterLights();
    this.screen = new Screen();
    this.popcornPoper = new PopcornPoper();
  }

  void watchMovie(){
    //1. 팝콘 기계를 켠다
    popcornPoper.on();

    // 2. 팝콘 튀김
    popcornPoper.pop();

    //3. 조명을 어둡게 조절
    theaterLights.on();
    theaterLights.setDim(10);

    //4. 스크린을 내린다.
    screen.down();

    //5. 프로젝터를 켠다.
    projector.on();

    //6. 프로젝터 플레이어를 스트리밍 플레이어로 설정

    projector.setPlayer(player);

    //7. 와이드 스크린 모드로 설정
    projector.wideScreenMode();

    //8. 앰프를 켠다
    amplifer.on();

    //9. 앰프 입력을 스트리밍 플레이어로 전환
    amplifer.setPlayer(player);

    //10. 앰프를 서라운드 음향 모드로 전환
    amplifer.setSurroundSound();

    //11. 앰프 볼륨을 중간(5) 로 설정
    amplifer.setVolume((short) 5);

    //12. 스트리밍 플레이어를 켠다.
    player.on();

    //13. 영화를 재생
    player.play();
  }

  void endMovie(){
    System.out.println("홈시어터를 끄는중");
    popcornPoper.off();
    theaterLights.off();
    screen.up();
    projector.off();
    amplifer.off();
    player.stop();
    player.off();
  }

}
