<template>
  <div>
    <el-menu
        style="width: 200px ;min-height: 20vh"
        default-active="user"
        router
        class="el-menu-vertical-demo">
      <el-menu-item index="Home">首页</el-menu-item>
      <el-menu-item index="User" >用户管理</el-menu-item>
      <el-menu-item index="Build" >楼宇管理</el-menu-item>
      <el-menu-item index="Dormitory">宿舍管理</el-menu-item>
      <el-menu-item index="Employee">员工管理</el-menu-item>
      <el-menu-item index="StudentInfo" >学生管理</el-menu-item>
      <el-menu-item index="AccessRegistration" >出入管理</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside",
  data() {
    return {
      loginfome: {
        role: '',
      },
      isshow: true,
    }
  },
  created() {
    let role = sessionStorage.getItem("user");

    if (JSON.parse(role).role[0].roleName == "系统管理员") {
      this.isshow = true;
    }else {
      this.isshow=false;
    }
  },
  methods: {
    exit(){
      // console.log("111")
      // alert("nihaoa ");
      sessionStorage.removeItem("user")
      this.$router.push({name:'Login'})
    },
  },

}
</script>

<style scoped>

</style>
