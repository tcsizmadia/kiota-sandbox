from __future__ import annotations
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Callable, Dict, List, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .person import Person

@dataclass
class Quote(AdditionalDataHolder, Parsable):
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: Dict[str, Any] = field(default_factory=dict)

    # The author property
    author: Optional[Person] = None
    # The content of the quote.
    content: Optional[str] = None
    # The unique identifier of the quote.
    id: Optional[int] = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: Optional[ParseNode] = None) -> Quote:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: Quote
        """
        if not parse_node:
            raise TypeError("parse_node cannot be null.")
        return Quote()
    
    def get_field_deserializers(self,) -> Dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: Dict[str, Callable[[ParseNode], None]]
        """
        from .person import Person

        from .person import Person

        fields: Dict[str, Callable[[Any], None]] = {
            "author": lambda n : setattr(self, 'author', n.get_object_value(Person)),
            "content": lambda n : setattr(self, 'content', n.get_str_value()),
            "id": lambda n : setattr(self, 'id', n.get_int_value()),
        }
        return fields
    
    def serialize(self,writer: SerializationWriter) -> None:
        """
        Serializes information the current object
        param writer: Serialization writer to use to serialize this model
        Returns: None
        """
        if not writer:
            raise TypeError("writer cannot be null.")
        writer.write_object_value("author", self.author)
        writer.write_str_value("content", self.content)
        writer.write_int_value("id", self.id)
        writer.write_additional_data_value(self.additional_data)
    

