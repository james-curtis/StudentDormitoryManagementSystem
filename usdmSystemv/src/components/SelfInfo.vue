<template>
  <div style="margin-left:30px;margin-top: 100px ">
    <el-descriptions  title="个人信息" >
      <el-descriptions-item label="编号">{{Sinfo.num}}</el-descriptions-item>
      <el-descriptions-item label="姓名">{{Sinfo.name}}</el-descriptions-item>
      <el-descriptions-item label="密码">{{Sinfo.password}}</el-descriptions-item>
      <el-descriptions-item label="手机号">{{Sinfo.telephone}}</el-descriptions-item>
      <el-descriptions-item label="身份">{{Sinfo.role[0].roleName}}  </el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<script>
export default {
  name: "SelfInfo",
  data(){
    return{
      Sinfo:'',
    }
  },
  created() {
    let info = sessionStorage.getItem("user");
    this.Sinfo=JSON.parse(info);



  }
}
</script>

<style scoped>

</style>