/*
 * This file is generated by jOOQ.
 */
package org.crazyit.generated.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.crazyit.generated.CrazySpringboot;
import org.crazyit.generated.Keys;
import org.crazyit.generated.tables.records.ClazzInfStudentsRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ClazzInfStudents extends TableImpl<ClazzInfStudentsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>crazy_springboot.clazz_inf_students</code>
     */
    public static final ClazzInfStudents CLAZZ_INF_STUDENTS = new ClazzInfStudents();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClazzInfStudentsRecord> getRecordType() {
        return ClazzInfStudentsRecord.class;
    }

    /**
     * The column
     * <code>crazy_springboot.clazz_inf_students.clazz_clazz_code</code>.
     */
    public final TableField<ClazzInfStudentsRecord, Integer> CLAZZ_CLAZZ_CODE = createField(DSL.name("clazz_clazz_code"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column
     * <code>crazy_springboot.clazz_inf_students.students_student_id</code>.
     */
    public final TableField<ClazzInfStudentsRecord, Integer> STUDENTS_STUDENT_ID = createField(DSL.name("students_student_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private ClazzInfStudents(Name alias, Table<ClazzInfStudentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private ClazzInfStudents(Name alias, Table<ClazzInfStudentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>crazy_springboot.clazz_inf_students</code> table
     * reference
     */
    public ClazzInfStudents(String alias) {
        this(DSL.name(alias), CLAZZ_INF_STUDENTS);
    }

    /**
     * Create an aliased <code>crazy_springboot.clazz_inf_students</code> table
     * reference
     */
    public ClazzInfStudents(Name alias) {
        this(alias, CLAZZ_INF_STUDENTS);
    }

    /**
     * Create a <code>crazy_springboot.clazz_inf_students</code> table reference
     */
    public ClazzInfStudents() {
        this(DSL.name("clazz_inf_students"), null);
    }

    public <O extends Record> ClazzInfStudents(Table<O> child, ForeignKey<O, ClazzInfStudentsRecord> key) {
        super(child, key, CLAZZ_INF_STUDENTS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : CrazySpringboot.CRAZY_SPRINGBOOT;
    }

    @Override
    public UniqueKey<ClazzInfStudentsRecord> getPrimaryKey() {
        return Keys.KEY_CLAZZ_INF_STUDENTS_PRIMARY;
    }

    @Override
    public List<UniqueKey<ClazzInfStudentsRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_CLAZZ_INF_STUDENTS_UK_7OW7HS58567H9H3N20RBFCWWJ);
    }

    @Override
    public List<ForeignKey<ClazzInfStudentsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FKI6P60V35CDAWQA8HPJ0J6635A, Keys.FKPF7OBUPPWYVX46FKK2F3F9XTV);
    }

    private transient ClazzInf _clazzInf;
    private transient StudentInf _studentInf;

    /**
     * Get the implicit join path to the <code>crazy_springboot.clazz_inf</code>
     * table.
     */
    public ClazzInf clazzInf() {
        if (_clazzInf == null)
            _clazzInf = new ClazzInf(this, Keys.FKI6P60V35CDAWQA8HPJ0J6635A);

        return _clazzInf;
    }

    /**
     * Get the implicit join path to the
     * <code>crazy_springboot.student_inf</code> table.
     */
    public StudentInf studentInf() {
        if (_studentInf == null)
            _studentInf = new StudentInf(this, Keys.FKPF7OBUPPWYVX46FKK2F3F9XTV);

        return _studentInf;
    }

    @Override
    public ClazzInfStudents as(String alias) {
        return new ClazzInfStudents(DSL.name(alias), this);
    }

    @Override
    public ClazzInfStudents as(Name alias) {
        return new ClazzInfStudents(alias, this);
    }

    @Override
    public ClazzInfStudents as(Table<?> alias) {
        return new ClazzInfStudents(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ClazzInfStudents rename(String name) {
        return new ClazzInfStudents(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ClazzInfStudents rename(Name name) {
        return new ClazzInfStudents(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ClazzInfStudents rename(Table<?> name) {
        return new ClazzInfStudents(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
