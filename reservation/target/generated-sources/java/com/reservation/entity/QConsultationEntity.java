package com.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConsultationEntity is a Querydsl query type for ConsultationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConsultationEntity extends EntityPathBase<ConsultationEntity> {

    private static final long serialVersionUID = 537706888L;

    public static final QConsultationEntity consultationEntity = new QConsultationEntity("consultationEntity");

    public final NumberPath<Integer> buildCd = createNumber("buildCd", Integer.class);

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath deleteFlg = createString("deleteFlg");

    public final NumberPath<Integer> depth = createNumber("depth", Integer.class);

    public final NumberPath<Integer> grgrod = createNumber("grgrod", Integer.class);

    public final NumberPath<Integer> grno = createNumber("grno", Integer.class);

    public final StringPath lockFlg = createString("lockFlg");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath passwd = createString("passwd");

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QConsultationEntity(String variable) {
        super(ConsultationEntity.class, forVariable(variable));
    }

    public QConsultationEntity(Path<? extends ConsultationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConsultationEntity(PathMetadata metadata) {
        super(ConsultationEntity.class, metadata);
    }

}

