package cn.edu.swpu.scs.eia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 监控表
 * </p>
 *
 * @author sunyang
 * @since 2022-05-07
 */
@Getter
@Setter
  @ApiModel(value = "Health对象", description = "健康表")
public class Health implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("自增ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("用户id")
      private Integer userId;

      @TableField(exist = false)
      private String username;

      @ApiModelProperty("问题1")
      private String option1;

      @ApiModelProperty("问题2")
      private String option2;

      @ApiModelProperty("问题3")
      private String option3;

      @ApiModelProperty("问题4")
      private String option4;

      @ApiModelProperty("问题5")
      private String option5;

      @ApiModelProperty("问题6")
      private String option6;

      @ApiModelProperty("问题7")
      private String option7;

      @ApiModelProperty("创建时间")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime createTime;


}
