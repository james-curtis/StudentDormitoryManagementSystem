<template>
  <div

      style="height: 50px; line-height: 50px; border-bottom: 1px solid #2aa797; display: flex ; background-color:#2aa797 ">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color:#303133">高校学生宿舍管理系统</div>
    <!--    <div style="flex: 1"></div>-->
    <div style="width: 60px ;display: inline;padding-left: 75%">
      <el-dropdown>
        <el-button plain>
          {{ username }} <i class="el-icon-arrow-down el-icon--right"></i>
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item @click.native="toInfo">个人信息</el-dropdown-item>
<!--          <el-dropdown-item @click.native="exit">退出系统</el-dropdown-item>-->
          <el-dropdown-item @click="exit">退出系统</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      username: ''
    }
  },
  methods: {
    exit(){
      // console.log("111")
      // alert("nihaoa ");
      sessionStorage.removeItem("user")
      this.$router.push({name:'Login'})
    },
    toInfo(){
      this.$router.push({name:'SelfInfo'})
    }
  },
  created() {
    let user = sessionStorage.getItem("user");
    this.username = JSON.parse(user).name;
  }
}
</script>

<style scoped>

</style>
