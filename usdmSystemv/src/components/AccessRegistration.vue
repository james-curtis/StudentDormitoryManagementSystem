<template>

  <div>
    <div id="select_id" style="width: 350px ;display: flex ;margin-top: 10px;margin-left: 10px">
      <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="param"></el-input>
      <el-button type="primary" style="margin-left: 10px" @click="local"> 搜索</el-button>
    </div>
    <!--    按钮区-->
    <div style="margin-left: 10px ; margin-top: 10px">
      <el-button type="primary" @click="dialogVisible=true">新增</el-button>
    </div>
    <div style="margin: 10px">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="编号" width="180"></el-table-column>
        <el-table-column prop="name" label="姓名" width="230"></el-table-column>
        <el-table-column prop="identity" label="身份" width="230"></el-table-column>
        <el-table-column prop="time" label="出入时间" width="230"></el-table-column>
        <el-table-column prop="bname" label="出入楼" width="190"></el-table-column>
      </el-table>

      <el-dialog title="弹窗" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
        <el-form ref="form" v-model="from" label-width="80px">

          <el-form-item label="姓名">
            <el-input v-model="from.name"></el-input>
          </el-form-item>

          <el-form-item label="身份">
            <el-input v-model="from.identity"></el-input>
          </el-form-item>
          <el-form-item label="出入时间">
            <el-input v-model="from.time"></el-input>
          </el-form-item>
          <el-form-item label="出入楼">
            <el-input v-model="from.bname"></el-input>
          </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save(); dialogVisible = false">确 定</el-button>
  </span>
      </el-dialog>


    </div>
  </div>
</template>

<script>
import request from "@/until";

export default {
  name: "AccessRegistration",
  data() {
    return {
      dialogVisible:false,
      param: '',
      tableData: [],
      from: {
        name: '',
        bname: '',
        identity: '',
        time: '',
        id: '',
      }
    }
  },
  created() {
    this.local()
  },
  methods: {
    handleClose(done) {
      done();
      this.dialogVisible = false
    },
    local() {
      request.get("/api/inout/search", {
        params: {
          param: this.param,
        }
      }).then(res => {
        console.log(res.data)
        this.tableData = res.data
      })
    },
    save() {
      request.post("/api/inout/add", this.from).then(res => {
        if (res.code === "0") {
          this.$message({
            type: "success",
            message: "添加成功"
          })
          this.local();
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true;
    },

    handleDelete(row) {
      console.log(row)
    },
  }
}
</script>

<style scoped>

</style>
