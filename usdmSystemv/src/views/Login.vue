<template>
  <div style="width: 100%; height: 100vh;background-color: darkolivegreen ; overflow:hidden ">
    <div style="width: 400px;margin: 110px auto">
      <div style="font-size: 30px ;color: #cccccc ;text-align: center ;padding: 30px">欢迎光临</div>
      <el-form ref="form" :model="form">
        <el-form-item>
          <el-input prefix-icon="el-icon-user-solid" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input prefix-icon="el-icon-lock" v-model="form.password" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>


import request from "@/until";

export default {
  name: "Login",
  data() {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    login() {
      request.post("/api/Login", this.form).then(res => {
        // alert(res.code)
        if (res.code === '0') {
          this.$message({
            type: "success",
            message: "登录成功",
          })
          // console.log(res)
          // 存用户信息
          sessionStorage.setItem("user", JSON.stringify(res.data));
          // 跳转到目标地址
          // this.$router.push({name: "Home", params: {form: this.res.data}})
          this.$router.push({name: "Home"})
        } else {
          console.log(111)
          this.$router.push({name: "Login"})
          this.$message({
            type: "error",
            message: res.msg
          })

        }

      })

    },

  }
}
</script>

<style scoped>

</style>