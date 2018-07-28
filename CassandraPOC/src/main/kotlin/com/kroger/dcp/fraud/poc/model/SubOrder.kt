package com.kroger.dcp.fraud.poc.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class SubOrder(
    val adjustments: List<Adjustment>,
    val cancelable: Boolean,
    val contactInfo: ContactInfo?,
    val createdDate: String,
    val destinationAddress: Address?,
    val etag: String,
    val fulfillmentType: FulfillmentType,
    val modifiable: Boolean,
//    val modifiableInChannelUntil: Instant,
//    val parentMasterOrder: Order,
//    val paymentInfo: PaymentInfo
    val reservationInfo: ReservationInfo,
//    val shoppingContext: ShoppingContext,
    val status: SubOrderStatus,
//    val storeId: StoreId,
    val subOrderId: String,
    val subOrderItems: List<SubOrderItem>,
    val subOrderUuid: String
)

data class Adjustment(
    val amount: BigDecimal,
    val name: String,
    val type: AdjustmentType,
    val upc: String
)

data class ContactInfo(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)


data class Address(
    val addressLine1: String,
    val addressLine2: String?,
    val city: String,
    val countryCode: String,
    val state: String,
    val zip: String
)

data class ReservationInfo(
    val expirationDate: String,
    val pickupBeginTime: String,
    val pickupDate: String,
    val pickupEndTime: String,
    val reservationId: String,
    val slotType: String,
    val storeId: String,
    val storeInformation: StoreInfo
)

data class StoreId(
    val divisionNumber: String,
    val storeNumber: String
)

data class StoreInfo(
    val addressLineOne: String,
    val latLong: String,
    val city: String,
    val phoneNumber: String,
    val state: String,
    val vanityName: String,
    val zipCode: String
)

data class ShoppingContext(
    val banner: String,
    val storeId: StoreId
)

data class SubOrderItem(
    val allowSubstitutes: Boolean,
    val description: String,
//    val index: Int,
//    val parentSubOrder: SubOrder,
    val priceInfo: ItemPriceInfo,
    val quantity: Int,
    val specialInstructions: String?,
    val unitOfMeasure: String,
    val upc: String
)

data class ItemPriceInfo(
    val promotionPrice: BigDecimal?,
    val regularPrice: BigDecimal
)

enum class AdjustmentType {
    Fee, Promotion
}

enum class FulfillmentType {
    CurbSide, ShipToHome, HomeDelivery
}

enum class SubOrderStatus {
    Pending, Submitted, ModifySubmitted, CancelSubmitted, Acknowledged, Cancelled, LockedByFulfillmentChannel, Complete
}
