<template>
  <section class="body">
    <div class="container">
      <div class="register-container">
        <div class="logo">
          <img src="../assets/logo-100.jpg" alt="" width="110">
        </div>

        <div class="info-container">
          <div class="user-input">
            <i class="fas fa-user"></i>
            <input type="text" placeholder="Username" v-model="userData.username">
          </div>
          <div class="user-input">
            <i class="fas fa-envelope"></i>
            <input type="text" placeholder="Email" v-model="userData.email">
          </div>
        </div>

        <div class="error-container">
          <div class="error" :style="{visibility: !isValidUsername ? 'visible' : 'hidden'}">Username must be filled and at least 6 characters</div>
          <div class="error" :style="{visibility: !isValidEmail ? 'visible' : 'hidden'}">Wrong email format</div>
        </div>

        <div class="info-container">
          <div class="user-input">
            <i class="fas fa-unlock-alt"></i>
            <input type="password" placeholder="Password" v-model="userData.password">
          </div>
          <div class="user-input">
            <i class="fas fa-unlock-alt"></i>
            <input type="password" placeholder="Re-type Password" v-model="repassword">
          </div>
        </div>

        <div class="error-container">
          <div class="error" :style="{visibility: !isValidPassword ? 'visible' : 'hidden'}">Password must be filled and at least 6 characters</div>
          <div class="error" :style="{visibility: !isValidRepassword ? 'visible' : 'hidden'}">Password did not match</div>
        </div>

        <div class="info-container">
          <div class="user-input">
            <i class="fas fa-venus-mars"></i>
            <input type="radio" v-model="userData.gender" value="male" name="gender">Male &nbsp;
            <input type="radio" v-model="userData.gender" value="female" name="gender">Female
          </div>
          <div class="user-input">
            <i class="fas fa-flag"></i>
            <select v-model="userData.country">
              <option value="">Choose your country</option>
              <option value="indonesia">Indonesia</option>
              <option value="singapore">Singapore</option>
              <option value="malaysia">Malaysia</option>
            </select>
          </div>
        </div>

        <div class="error-container">
          <div class="error" :style="{visibility: !isValidGender ? 'visible' : 'hidden'}">Gender must be filled</div>
          <div class="error" :style="{visibility: !isValidCountry ? 'visible' : 'hidden'}">You must choose your country</div>
        </div>

        <div class="btn-login">
          <b-button type="is-primary btn" @click="validateRegister()">Register</b-button>
        </div>

        <div class="error-container">
          <div class="error" v-show="!agreement">You must agree to terms and conditions!</div>
        </div>

        <div>
          <input type="checkbox" v-model="agreement"> &nbsp; I agree to term's and conditions
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'RegisterPage',
  data () {
    return {
      userData: {
        username: '',
        email: '',
        password: '',
        gender: '',
        country: ''
      },
      repassword: '',
      agreement: false
    }
  },
  methods: {
    validateRegister () {
      if(!this.agreement ||
         !this.isValidUsername ||
         !this.isValidEmail ||
         !this.isValidPassword ||
         !this.isValidRepassword ||
         !this.isValidGender ||
         !this.isValidCountry) return
      this.$router.push('/home')
    }
  },
  computed: {
    isValidUsername () {
      if (!this.userData.username || this.userData.username.length < 6) return false
      return true
    },
    isValidEmail () {
      let flag=0
      if(this.userData.email.indexOf('@') > 0) flag++
      if(this.userData.email.includes('@')) flag++
      if(this.userData.email.includes('.')) flag++
      if(this.userData.email.indexOf('@')+1 != this.userData.email.indexOf('.')) flag++
      if(this.userData.email.indexOf('.')+1 != this.userData.email.indexOf('@')) flag++

      if(flag == 5) return true
      else return false
    },
    isValidPassword () {
      if (!this.userData.password || this.userData.password.length < 6) return false
      return true
    },
    isValidRepassword () {
      if (this.repassword !== this.userData.password) return false
      return true
    },
    isValidGender () {
      if(!this.userData.gender) return false
      return true
    },
    isValidCountry () {
      if(!this.userData.country) return false
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

%content-items-center {
  display: flex;
  align-items: center;
}

%content-items-spaceAround {
  display: flex;
  align-items: center;
  justify-content: space-around;
}

.register-container {
  width: 50%;
  height: 580px;
  margin: 70px auto 100px auto;
  border: 1px solid white;
  border-radius: 15px;
  box-shadow: 2px 0px 23px 4px rgba(148,148,148,1);
  background-color: rgba(255, 255, 255, 1);
  @extend %content-center-row;

  .logo {
    height: 25%;
    width: 100%;
    margin-bottom: 20px;
    margin-top: 5px;
    @extend %content-center;
  }

  .error {
    font-size: 12px;
    color: red;
    width: 50%;
    padding-left: 5px;
  }

  .error-container {
    width: 89%;
    display: flex;
    margin-top: -10px;
    margin-bottom: 15px;
  }

  .info-container {
    width: 90%;
    height: 50px;
    margin-bottom: 15px;
    @extend %content-items-spaceAround;

    .user-input {
      width: 49%;
      height: 100%;
      border: 1px solid #bababa;
      border-radius: 7px;
      box-shadow: 1px 0px 4px 0px #bababa;
      @extend %content-items-center;

      i {
        font-size: 15px;
        margin-right: 10px;
        margin-left: 10px;
      }

      input[type=text] {
        width: 250px;
      }

      input[type=password] {
        width: 250px;
      }

      input {
        border: none;
        height: 100%;
      }

      input:focus {
        outline: none !important;
      }

      select {
        max-width: 200%;
      }
    }

  }

  .btn-login {
    @extend %content-center;
    width: 90%;
    margin-bottom: 15px;

    .btn {
      width: 100%;
    }
  }

}


</style>
