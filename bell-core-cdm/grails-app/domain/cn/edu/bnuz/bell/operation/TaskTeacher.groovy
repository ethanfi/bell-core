package cn.edu.bnuz.bell.operation

import cn.edu.bnuz.bell.organization.Teacher
import org.codehaus.groovy.util.HashCodeHelper

/**
 * 教学任务-教师
 * @author Yang Lin
 */
class TaskTeacher implements Serializable {
    private static final long serialVersionUID = 1

    /**
     * 教师
     */
    Teacher teacher

    static belongsTo = [task: Task]

    static mapping = {
        comment '任务-教师'
        table   schema: 'ea'
        id      composite: ['task', 'teacher'], comment: '安排-教师ID'
        teacher comment: '任课教师'
        task    comment: '教学任务'
    }

    boolean equals(other) {
        if (!(other instanceof TaskTeacher)) {
            return false
        }

        other.task?.id == task?.id && other.teacher?.id == teacher?.id
    }

    int hashCode() {
        int hash = HashCodeHelper.initHash()
        hash = HashCodeHelper.updateHash(hash, task.id)
        hash = HashCodeHelper.updateHash(hash, teacher.id)
        hash
    }
}
