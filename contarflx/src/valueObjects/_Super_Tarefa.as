/**
 * This is a generated class and is not intended for modification.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - Tarefa.as.
 */

package valueObjects
{
import com.adobe.fiber.services.IFiberManagingService;
import com.adobe.fiber.valueobjects.IValueObject;
import flash.events.EventDispatcher;
import mx.collections.ArrayCollection;
import mx.events.PropertyChangeEvent;

import flash.net.registerClassAlias;
import flash.net.getClassByAlias;
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.valueobjects.IPropertyIterator;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

use namespace model_internal;

[ExcludeClass]
public class _Super_Tarefa extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void
    {
        try
        {
            if (flash.net.getClassByAlias("br.arthur.contarsrv.domain.Tarefa") == null)
            {
                flash.net.registerClassAlias("br.arthur.contarsrv.domain.Tarefa", cz);
            }
        }
        catch (e:Error)
        {
            flash.net.registerClassAlias("br.arthur.contarsrv.domain.Tarefa", cz);
        }
    }

    model_internal static function initRemoteClassAliasAllRelated() : void
    {
    }

    model_internal var _dminternal_model : _TarefaEntityMetadata;
    model_internal var _changedObjects:mx.collections.ArrayCollection = new ArrayCollection();

    public function getChangedObjects() : Array
    {
        _changedObjects.addItemAt(this,0);
        return _changedObjects.source;
    }

    public function clearChangedObjects() : void
    {
        _changedObjects.removeAll();
    }

    /**
     * properties
     */
    private var _internal_agente : int;
    private var _internal_dataFim : Date;
    private var _internal_sistema : String;
    private var _internal_dataInicioISO : String;
    private var _internal_codTarefa : int;
    private var _internal_nome : String;
    private var _internal_dataInicioFormatada : String;
    private var _internal_dataInicio : Date;
    private var _internal_descricao : String;
    private var _internal_status : String;

    private static var emptyArray:Array = new Array();


    /**
     * derived property cache initialization
     */
    model_internal var _cacheInitialized_isValid:Boolean = false;

    model_internal var _changeWatcherArray:Array = new Array();

    public function _Super_Tarefa()
    {
        _model = new _TarefaEntityMetadata(this);

        // Bind to own data or source properties for cache invalidation triggering

    }

    /**
     * data/source property getters
     */

    [Bindable(event="propertyChange")]
    public function get agente() : int
    {
        return _internal_agente;
    }

    [Bindable(event="propertyChange")]
    public function get dataFim() : Date
    {
        return _internal_dataFim;
    }

    [Bindable(event="propertyChange")]
    public function get sistema() : String
    {
        return _internal_sistema;
    }

    [Bindable(event="propertyChange")]
    public function get dataInicioISO() : String
    {
        return _internal_dataInicioISO;
    }

    [Bindable(event="propertyChange")]
    public function get codTarefa() : int
    {
        return _internal_codTarefa;
    }

    [Bindable(event="propertyChange")]
    public function get nome() : String
    {
        return _internal_nome;
    }

    [Bindable(event="propertyChange")]
    public function get dataInicioFormatada() : String
    {
        return _internal_dataInicioFormatada;
    }

    [Bindable(event="propertyChange")]
    public function get dataInicio() : Date
    {
        return _internal_dataInicio;
    }

    [Bindable(event="propertyChange")]
    public function get descricao() : String
    {
        return _internal_descricao;
    }

    [Bindable(event="propertyChange")]
    public function get status() : String
    {
        return _internal_status;
    }

    public function clearAssociations() : void
    {
    }

    /**
     * data/source property setters
     */

    public function set agente(value:int) : void
    {
        var oldValue:int = _internal_agente;
        if (oldValue !== value)
        {
            _internal_agente = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "agente", oldValue, _internal_agente));
        }
    }

    public function set dataFim(value:Date) : void
    {
        var oldValue:Date = _internal_dataFim;
        if (oldValue !== value)
        {
            _internal_dataFim = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "dataFim", oldValue, _internal_dataFim));
        }
    }

    public function set sistema(value:String) : void
    {
        var oldValue:String = _internal_sistema;
        if (oldValue !== value)
        {
            _internal_sistema = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "sistema", oldValue, _internal_sistema));
        }
    }

    public function set dataInicioISO(value:String) : void
    {
        var oldValue:String = _internal_dataInicioISO;
        if (oldValue !== value)
        {
            _internal_dataInicioISO = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "dataInicioISO", oldValue, _internal_dataInicioISO));
        }
    }

    public function set codTarefa(value:int) : void
    {
        var oldValue:int = _internal_codTarefa;
        if (oldValue !== value)
        {
            _internal_codTarefa = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "codTarefa", oldValue, _internal_codTarefa));
        }
    }

    public function set nome(value:String) : void
    {
        var oldValue:String = _internal_nome;
        if (oldValue !== value)
        {
            _internal_nome = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "nome", oldValue, _internal_nome));
        }
    }

    public function set dataInicioFormatada(value:String) : void
    {
        var oldValue:String = _internal_dataInicioFormatada;
        if (oldValue !== value)
        {
            _internal_dataInicioFormatada = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "dataInicioFormatada", oldValue, _internal_dataInicioFormatada));
        }
    }

    public function set dataInicio(value:Date) : void
    {
        var oldValue:Date = _internal_dataInicio;
        if (oldValue !== value)
        {
            _internal_dataInicio = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "dataInicio", oldValue, _internal_dataInicio));
        }
    }

    public function set descricao(value:String) : void
    {
        var oldValue:String = _internal_descricao;
        if (oldValue !== value)
        {
            _internal_descricao = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "descricao", oldValue, _internal_descricao));
        }
    }

    public function set status(value:String) : void
    {
        var oldValue:String = _internal_status;
        if (oldValue !== value)
        {
            _internal_status = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "status", oldValue, _internal_status));
        }
    }

    /**
     * Data/source property setter listeners
     *
     * Each data property whose value affects other properties or the validity of the entity
     * needs to invalidate all previously calculated artifacts. These include:
     *  - any derived properties or constraints that reference the given data property.
     *  - any availability guards (variant expressions) that reference the given data property.
     *  - any style validations, message tokens or guards that reference the given data property.
     *  - the validity of the property (and the containing entity) if the given data property has a length restriction.
     *  - the validity of the property (and the containing entity) if the given data property is required.
     */


    /**
     * valid related derived properties
     */
    model_internal var _isValid : Boolean;
    model_internal var _invalidConstraints:Array = new Array();
    model_internal var _validationFailureMessages:Array = new Array();

    /**
     * derived property calculators
     */

    /**
     * isValid calculator
     */
    model_internal function calculateIsValid():Boolean
    {
        var violatedConsts:Array = new Array();
        var validationFailureMessages:Array = new Array();

        var propertyValidity:Boolean = true;

        model_internal::_cacheInitialized_isValid = true;
        model_internal::invalidConstraints_der = violatedConsts;
        model_internal::validationFailureMessages_der = validationFailureMessages;
        return violatedConsts.length == 0 && propertyValidity;
    }

    /**
     * derived property setters
     */

    model_internal function set isValid_der(value:Boolean) : void
    {
        var oldValue:Boolean = model_internal::_isValid;
        if (oldValue !== value)
        {
            model_internal::_isValid = value;
            _model.model_internal::fireChangeEvent("isValid", oldValue, model_internal::_isValid);
        }
    }

    /**
     * derived property getters
     */

    [Transient]
    [Bindable(event="propertyChange")]
    public function get _model() : _TarefaEntityMetadata
    {
        return model_internal::_dminternal_model;
    }

    public function set _model(value : _TarefaEntityMetadata) : void
    {
        var oldValue : _TarefaEntityMetadata = model_internal::_dminternal_model;
        if (oldValue !== value)
        {
            model_internal::_dminternal_model = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "_model", oldValue, model_internal::_dminternal_model));
        }
    }

    /**
     * methods
     */


    /**
     *  services
     */
    private var _managingService:com.adobe.fiber.services.IFiberManagingService;

    public function set managingService(managingService:com.adobe.fiber.services.IFiberManagingService):void
    {
        _managingService = managingService;
    }

    model_internal function set invalidConstraints_der(value:Array) : void
    {
        var oldValue:Array = model_internal::_invalidConstraints;
        // avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_invalidConstraints = value;
            _model.model_internal::fireChangeEvent("invalidConstraints", oldValue, model_internal::_invalidConstraints);
        }
    }

    model_internal function set validationFailureMessages_der(value:Array) : void
    {
        var oldValue:Array = model_internal::_validationFailureMessages;
        // avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_validationFailureMessages = value;
            _model.model_internal::fireChangeEvent("validationFailureMessages", oldValue, model_internal::_validationFailureMessages);
        }
    }


}

}
