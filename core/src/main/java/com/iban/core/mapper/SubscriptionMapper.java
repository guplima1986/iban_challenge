package com.iban.core.mapper;

import com.iban.core.model.Subscription;
import com.iban.core.model.dto.SubscriptionDto;
import com.iban.core.requests.SubscriptionRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper( SubscriptionMapper.class );

    @Mapping(source = "campaign.id", target = "campaign.name")
    SubscriptionDto subscriptionToSubscriptionDto(Subscription subscription);

    Subscription subscriptionDtoToSubscription(SubscriptionDto subscriptionDto);

    @Mapping(source = "campaign", target = "campaign.id")
    Subscription subscriptionRequestBodyToSubscription(SubscriptionRequestBody subscriptionRequestBody);
}
