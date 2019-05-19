<template>
  <section class="body">
    <div class="container">
      <div class="login-container">
        <div class="logo">
          <img src="../assets/logo-100.jpg" alt="" width="110">
        </div>
        <div class="user-input">
          <i class="fas fa-user"></i>
          <input type="text" placeholder="Username" v-model="userData.username">
        </div>
        <span class="error" v-show="!isValidUsername">Username must be filled</span>
        <div class="user-input">
          <i class="fas fa-unlock-alt"></i>
          <input type="password" placeholder="Password" v-model="userData.password">
        </div>
        <span class="error" v-show="!isValidPassword">Password must be filled</span>
        <div class="btn-login">
          <b-button type="is-primary btn" @click="toRegisterPage()">Login</b-button>
        </div>
        <div class="regis-or-forgot">
          <router-link to="register">Register</router-link> or 
          <router-link to="forgot-password">Forgot Password</router-link> ?
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'LoginPage',
  data () {
    return {
      userData: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    toRegisterPage () {
      if(!this.isValidUsername || !this.isValidPassword) return
      this.$router.push('/home')
    }
  },
  computed: {
    isValidUsername () {
      if (!this.userData.username) return false
      return true
    },
    isValidPassword () {
      if (!this.userData.password) return false
      return true
    }
  }
}
</script>

<style scoped lang="scss">

.body {
  border: 1px solid black; //biar background image nya ga kena margin
  background-image: url("../assets/wallpaper.png");
  height: 722px;
}

%content-center {
  display: flex;
  justify-content: center;
  align-items: center;
}

%content-center-row {
  display: flex;
  align-items: center;
  flex-direction: column;
}

.login-container {
  width: 30%;
  height: 450px;
  margin: 100px auto 100px auto;
  border: 1px solid white;
  border-radius: 15px;
  box-shadow: 2px 0px 23px 4px rgba(148,148,148,1);
  background-color: rgba(255, 255, 255, 1);
  @extend %content-center-row;

  .logo {
    height: 35%;
    width: 100%;
    margin-bottom: 20px;
    margin-top: 5px;
    @extend %content-center;
  }

  .error {
    font-size: 12px;
    color: red;
    margin-top: -7px;
    margin-bottom: 15px;
    width: 70%;
  }

  .user-input {
    width: 70%;
    height: 9%;
    padding: 5px;
    margin-bottom: 15px;
    display: flex;
    align-items: center;
    border: 1px solid #bababa;
    border-radius: 7px;
    box-shadow: 1px 0px 4px 0px #bababa;

    i {
      font-size: 15px;
      margin-right: 10px;
      margin-left: 5px;
    }

    input[type=text] {
      width: 300px;
    }

    input[type=password] {
      width: 300px;
    }

    input {
      border: none;
      height: 100%;
    }

    input:focus {
      outline: none !important;
    }

    .radio {
      margin-right: 30px;
      border: 1px solid red;
    }
  }

  .btn-login {
    @extend %content-center;
    width: 70%;
    margin-bottom: 15px;

    .btn {
      width: 100%;
    }
  }
}
</style>
