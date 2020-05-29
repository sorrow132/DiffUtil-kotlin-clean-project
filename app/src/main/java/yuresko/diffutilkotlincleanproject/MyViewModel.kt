package yuresko.diffutilkotlincleanproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.subjects.BehaviorSubject

interface IViewModel {
    val items: LiveData<List<Something>>

    fun changePrice(index: Int, price: Int)
}

class MyViewModel(private val repo: SomeRepository) : ViewModel(), IViewModel {

    private val rxIsDiscountEnabled: BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    private val rxPriceModification: BehaviorSubject<Map<Int, Int>> = BehaviorSubject.createDefault(
        emptyMap()
    )

    override val items: MutableLiveData<List<Something>> = MutableLiveData()

    init {
        Observable
            .combineLatest(
                rxPriceModification,
                rxIsDiscountEnabled,
                repo.getItems(),
                Function3 { priceModification: Map<Int, Int>, isDiscountEnabled: Boolean, items: List<Something> ->
                    Triple(priceModification, isDiscountEnabled, items)
                }
            )
            .map { (priceModification, isDiscountEnabled, items) ->
                items.mapIndexed { index, something ->
                    if (isDiscountEnabled) {
                        something.copy(price = 0)
                    } else if (priceModification.containsKey(index)) {
                        something.copy(price = priceModification[index]!!)
                    } else {
                        something
                    }
                }
            }
            .subscribe {
                items.postValue(it)
            }
    }

    override fun changePrice(index: Int, price: Int) {
        val map = rxPriceModification.value?.toMutableMap() ?: HashMap()
        map[index] = price
        rxPriceModification.onNext(map)
        if (index == 5 && price == 1996) {
            rxIsDiscountEnabled.onNext(true)
        } else {
            rxIsDiscountEnabled.onNext(false)
        }
    }

}