
<template>
    <section class="home">

      <section class="swiper">
        <router-link to="register">
          <img
            src="../assets/about-careers-top.png"
          />
        </router-link>
        <div class="text">广告</div>
      </section>
<!-- 
            <section class="swiper">
              <router-link to="register">
                <img
                  src="../assets/homepage-banner.png"
                />
              </router-link>
              <div class="text">广告</div>
            </section> -->


      <section class="tags">
        <div class="wrapper">
          <div class="tag">
            <a href="https://starbucks.tmall.com/">
              <img
                src="../assets/tmall.png"
              />
            </a>
          </div>
          <div class="tag">
            <a href="#">
              <img
                src="../assets/design-studio.png"
              />
            </a>
          </div>
          <div class="tag">
            <a href="#">
              <img
                src="../assets/homepage-career.png"
              />
            </a>
          </div>
        </div>
      </section>
      <section class="club">
        <div class="wrapper-clear">
          <div class="wrapper-left">
            <h2 class="title">星享俱乐部</h2>
            <p class="text">
              开启您的星享之旅，星星越多、会员等级越高、好礼越丰富。
              <a href="#">了解更多 ›</a>
            </p>
            <div class="btn">
              <router-link to="register" class="reg">注册</router-link>
              <router-link to="login" class="login">登录</router-link>
            </div>
          </div>
          <div class="club-logo">
            <img
              src="../assets/starbucks-logo.png"
            />
          </div>
        </div>
      </section>
      <section class="tmall">
        <h2 class="title">星巴克精选</h2>
        <p class="text">在星巴克天猫旗舰店发现更多咖啡心意</p>
        <div class="wrapper">
          <div class="tag">
            <a href="https://starbucks.tmall.com/p/rd796757.htm">
              <img
                src="../assets/tmall-card.png"
                class="logo"
              />
              <h3 class="name">会员星礼包</h3>
              <p class="t1">星享卡新升级</p>
              <p class="t2">更多心意好礼</p>
              <a href="#" class="to_more">了解更多 ›</a>
            </a>
          </div>
          <div class="tag">
            <a href="https://starbucks.tmall.com/p/rd796757.htm">
              <img
                src="../assets/tmall-card-02.png"
                class="logo"
              />
              <h3 class="name">星礼卡</h3>
              <p class="t1">用一份心礼</p>
              <p class="t2">让心意相随</p>
              <a href="#" class="to_more">了解更多 ›</a>
            </a>
          </div>
          <div class="tag">
            <a href="https://starbucks.tmall.com/p/rd796757.htm">
              <img
                src="../assets/tmall-card-03.png"
                class="logo"
              />
              <h3 class="name">电子产品券</h3>
              <p class="t1">心意</p>
              <p class="t2">从这一杯开始</p>
              <a href="#" class="to_more">了解更多 ›</a>
            </a>
          </div>
          <div class="tag">
            <a href="https://starbucks.tmall.com/p/rd796757.htm">
              <img
                src="../assets/tmall-card-04.png"
                class="logo"
              />
              <h3 class="name">咖啡生活</h3>
              <p class="t1">星巴克</p>
              <p class="t2">用心制作</p>
              <a href="#" class="to_more">了解更多 ›</a>
            </a>
          </div>
        </div>
      </section>
      <section class="coffeehouse">
        <h2 class="title">1912 派克街 | 咖啡星讲堂</h2>
        <p class="text">了解更多星巴克咖啡文化</p>
       
        <div class="wrapper"id="knowledges">
          <div class="tag">
            <div class="label">咖啡品鉴</div>
            <p class="name">咖啡调制</p>
          </div>
          <div class="tag">
            <div class="label">咖啡知识</div>
            <p class="name">咖啡烘焙</p>
          </div>
          <div class="tag">
            <div class="label">咖啡品鉴</div>
            <p class="name">手冲咖啡</p>
          </div>
        </div>
      </section>
  
      
    </section>
  </template>
  
  <style scoped lang="less">

  h3 {
    font-family: "微软雅黑"
  }
  a:link {
    color:black;
    text-decoration: none;
  }
  a:visited {
    color:black;
    text-decoration: none;
  }
  .wrapper-clear {
    width: 500px;
    height: 250px;
    background-color: #fff;
  }
  .home {
    padding-bottom: 55px;
    background-color: #fff;
  }
  .swiper {
    width: 100%;
    position: relative;
    font-size: 0;
  
    img {
      width: 100%;
      src: url("../assets/banner-mobile.png");
    }
    .text {
      padding: 2px 6px;
      font-size: 13px;
      background-color: #11111178;
      color: #ffffffd1;
      border-radius: 3px;
      position: absolute;
      top: 10px;
      right: 10px;
    }
  }
  .tags {
    background-color: #f7f7f7;
    padding: 12px;
  
    .tag {
      display: inline-block;
      width: 33.33333%;
      padding: 12px;
      box-sizing: border-box;
  
      img {
        width: 100%;
        border-radius: 2px;
        box-shadow: 0px 2px 1px 0px #dcdcdc;
        transition: 200ms all;
        position: relative;
        top: 0;
      }
      img:hover {
        box-shadow: 0px 2px 5px -1px #7c7c7c;
        top: -5px;
      }
    }
  }
  .club {
    background-color: #fff;
    padding: 40px;
  
    .wrapper {
      max-width: 725px;
      margin: 0 auto;
    }
    .wrapper-left {
      width: 45%;
      float: left;
    }
    h2.title {
      font-size: 22px;
      font-weight: 500;
    }
    #knowledges {
      width: 1000px;
    }
    p.text {
      line-height: 32px;
      font-weight: 200;
      font-size: 16px;
      margin-top: 13px;
  
      a {
        color: #c2a661;
        font-weight: 500;
      }
    }
  
    .btn {
      margin-top: 30px;
    }
    .reg,
    .login {
      padding: 8px 18px;
      font-size: 16px;
      font-weight: 200;
      color: #00a862;
      border: 1px solid #00a862;
      border-radius: 20px;
      margin-right: 6px;
      display: inline-block;
    }
    .club-logo {
      float: right;
      width: 230px;
      margin-top: 50px;
      img {
        width: 100%;
      }
    }
  }
  .tmall {
    background-color: #f7f7f7;
    padding: 28px 0;
  
    h2.title {
      font-weight: 500;
      font-size: 20px;
      margin-top: 5px;
      text-align: center;
    }
    p.text {
      margin-top: 20px;
      font-weight: 200;
      text-align: center;
    }
    .wrapper {
      margin: 0 auto;
      margin-top: 72px;
      max-width: 725px;
      display: flex;
      align-content: space-between;
      justify-content: space-between;
    }
    .tag {
      width: 22.5%;
      box-shadow: 0px 1px 1px 1px #dcdcdc;
      padding: 27px 0px;
      box-sizing: border-box;
      position: relative;
      background-color: #fff;
      border-radius: 2px;
      transition: all 300ms;
      position: relative;
      top: 0;
  
      img.logo {
        position: absolute;
        width: 106px;
        top: -35px;
        left: 50%;
        margin-left: -53px;
      }
  
      h3.name {
        font-weight: 550;
        font-size: 16px;
        text-align: center;
        margin-top: 20px;
        margin-bottom: 14px;
      }
      p.t1,
      p.t2 {
        font-weight: 200;
        font-size: 14px;
        margin-top: 8px;
        text-align: center;
      }
      a.to_more {
        display: block;
        color: #d4c191;
        text-align: center;
        margin-top: 25px;
        font-size: 12px;
      }
    }
    .tag:hover {
      box-shadow: 0px 2px 3px 2px #dcdcdc;
      top: -5px;
    }
  }
  .coffeehouse {
    background-color: #fff;
    padding: 24px;
  
    h2.title {
      font-weight: 500;
      font-size: 20px;
      margin-top: 8px;
      text-align: center;
    }
    p.text {
      margin-top: 20px;
      font-weight: 200;
      text-align: center;
    }
    .wrapper {
      margin: 0 auto;
      margin-top: 40px;
      max-width: 1200px;
      display: flex;
      align-content: space-between;
      justify-content: space-between;
    }
    .tag {
      margin:20px;
      width: 400px;
      height: 240px;
      box-shadow: 0px 2px 2px 2px #dcdcdc;
      box-sizing: border-box;
      position: relative;
      background-color: #fff;
      border-radius: 2px;
      transition: all 300ms;
      position: relative;
      top: 0;
      overflow: hidden;
      background-image: url("../assets/knowledge-01.png");
      padding-top: 168px;
      background-position: -80px 0px;
      background-size: 600px;
  
      div.label {
        position: absolute;
        top: 5px;
        left: 0px;
        padding: 6px 10px;
        background-color: #c2a661;
        color: #fff;
        font-size: 14px;
      }
  
      p.name {
        font-size: 15px;
        background-color: #fff;
        height: 58px;
        padding: 16px;
        box-sizing: border-box;
      }
    }
    .tag:hover {
      box-shadow: 0px 2px 3px 2px #dcdcdc;
      top: -5px;
    }
    .tag:nth-child(2) {
      background-image: url("../assets/knowledge-02.png");
    }
    .tag:nth-child(3) {
      background-image: url("../assets/knowledge-03.png");
  }
  footer {
    p {
      text-align: center;
      line-height: 40px;
      font-size: 14px;
      font-weight: 500;
      font-family: "Gotham";
      letter-spacing: 1px;
      a {
        color: #666666;
      }
      a:hover {
        color: #111;
      }
  
      img {
        width: 10px;
      }
    }
  }
  @media (min-width: 1024px) {
  }
  @media (max-width: 1024px) and (min-width: 640px) {
  }
  @media (max-width: 640px) {
    .swiper {
      img {
        content: url("../assets/banner-mobile.png");
      }
    }
  
    .club {
      .wrapper-left {
        float: none;
        text-align: center;
        width: 100%;
      }
      .club-logo {
        float: none;
        text-align: center;
        width: 100%;
  
        img {
          width: 240px;
        }
      }
    }
  
    .tmall .wrapper {
      flex-wrap: wrap;
      justify-content: space-around;
  
      .tag {
        width: 45%;
      }
      .tag:nth-child(n + 3) {
        margin-top: 60px;
      }
    }
  
    .tags {
      padding: 12px 3px;
  
      .tag {
        width: 100%;
      }
    }
    .ad {
      display: none;
    }
    .to-register {
      flex-wrap: wrap;
      padding: 35px;
      div {
        text-align: center;
      }
    }
    .coffeehouse {
      padding: 30px 80px;
    }
    .coffeehouse .wrapper {
      flex-wrap: wrap;
      max-width: 300px;
      .tag {
        width: 100%;
        margin-bottom: -165px;
        position: relative;
        border-radius: 4px;
      }
      .tag:nth-child(1) {
        left: -40px;
      }
      .tag:nth-child(3) {
        left: 40px;
        margin-bottom: 0;
      }
    }
  }
}
</style>