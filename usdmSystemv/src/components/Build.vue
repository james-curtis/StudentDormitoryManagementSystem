<template>

  <div>
    <div id="select_id" style="width: 350px ;display: flex;margin-top: 10px;margin-left: 10px">
      <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="Bname"></el-input>
      <el-button type="primary" style="margin-left: 10px" @click="FindByName"> 搜索</el-button>
    </div>
    <!--    按钮区-->
    <div style="margin-left: 10px ; margin-top: 10px">
      <el-button type="primary" @click="dialogVisible= true">新增</el-button>
    </div>
    <div style="margin: 10px">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="编号" width="240"></el-table-column>
        <el-table-column prop="bname" label="楼宇名" width="290"></el-table-column>
        <el-table-column prop="bempName" label="楼管理员/宿管" width="320"></el-table-column>
        <!--        <el-table-column prop="ename" label="楼管理员/宿管" width="320"></el-table-column>-->
        <el-table-column align="left" label="操作" width="160">
          <template #default="scope">
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)">修改</el-button>
            <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row)">
              <template #reference>
                <el-button style="margin-left: 10px" size="mini" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>


      <el-dialog title="弹窗" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
        <el-form ref="form" v-model="from" label-width="80px">

          <el-form-item label="楼名">
            <el-input v-model="from.bname"></el-input>
          </el-form-item>

          <el-form-item label="楼管理员">
            <el-input v-model="from.bempName"></el-input>
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
  name: "Build",
  data() {
    return {
      from: {
        id: '',
        bname: '',
        bempName: '',

      },
      tableData: [],
      Bname:'',
      dialogVisible: false,

    }
  },
  created() {
    this.local();
  },
  methods: {
    /*查询全部*/
    local() {
      request.get("/api/building/search").then(res => {
        if (res.code === '0') {
          this.tableData = res.data
        }
      })
    },
    /*根据楼名查询*/
    FindByName() {
      request.get("/api/building/findByName", {
        params: {
          Bname: this.Bname
        }
      }).then(res => {
        this.tableData = res.data;
      })

    },
    /*更新或者修改*/
    save() {
      if (this.from.id) {//更新
        request.put("/api/building/updateBuild", this.from).then(res => {
          this.local()
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "更新成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      } else {// 添加
        request.post("/api/building/addBuild", this.from).then(res => {
          this.local()
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "添加成功"
            })

          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      }
      this.from={}
      this.dialogVisible=false

    },

    handleEdit(row) {
      let build = JSON.parse(JSON.stringify(row))
      this.from = build
      this.dialogVisible = true
    },

    handleDelete(row) {
      request.delete("/api/building/deteleBuild/" + row.id).then(res => {
        if (res.code === "0") {
          this.$message({
            type: "success",
            message: "删除成功"
          })
          this.local();
        } else {
          this.$message({
            type: "error",
            message: "删除失败"
          })
        }
      })
    },
    handleClose(done) {
      done();
      this.dialogVisible = false
    }
  }
}
</script>

<style scoped>

</style>
